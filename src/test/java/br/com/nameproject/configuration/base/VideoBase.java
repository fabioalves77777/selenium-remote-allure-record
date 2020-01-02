package br.com.nameproject.configuration.base;

import static com.automation.remarks.video.RecordingUtils.doVideoProcessing;
import static com.automation.remarks.video.RecordingUtils.videoEnabled;

import java.io.File;
import org.junit.AssumptionViolatedException;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.automation.remarks.video.RecorderFactory;
import com.automation.remarks.video.RecordingUtils;
import com.automation.remarks.video.annotations.Video;
import com.automation.remarks.video.recorder.IVideoRecorder;
import com.automation.remarks.video.recorder.VideoRecorder;

public class VideoBase extends TestWatcher {

    private IVideoRecorder recorder;

    /**
     * Método que inicializa a gravação do vídeo
     */
    @Override
    protected void starting(Description description) {
        if (videoDisabled(description)) return;
        recorder = RecorderFactory.getRecorder(VideoRecorder.conf().recorderType());
        recorder.start();
    }

    /**
     * Método que manipula o vídeo em caso de sucesso
     * @false grava o vídeo // @true apaga vídeo
     */
    @Override
    protected void succeeded(Description description) {
        File video = stopRecording(getFileName(description));
        doVideoProcessing(false, video);
    }

    /**
     * Método que manipula o vídeo em caso de falha
     * @false grava o vídeo // @true apaga vídeo
     */
    @Override
    protected void failed(Throwable e, Description description) {
        if (videoDisabled(description)) return;
        File video = stopRecording(getFileName(description));
        doVideoProcessing(false, video);
    }

    /**
     * Método que manipula o vídeo em caso de pular o cenário
     */
    @Override
    protected void skipped(AssumptionViolatedException e, Description description) {
        failed(e, description);
    }

    /**
     * Método que habilita ou desabilita a gravação de vídeo 
     */
    private boolean videoDisabled(Description description){
        return !videoEnabled(description.getAnnotation(Video.class));
    }

    /**
     * Método que retorna o nome do arquivo
     */
    protected String getFileName(Description description) {
        return RecordingUtils.getVideoFileName(description.getAnnotation(Video.class), description.getMethodName());
    }

    /**
     * Método que para e retorna o vídeo gravado
     */
    private File stopRecording(String filename) {
        if (recorder != null) 
        	return recorder.stopAndSave(filename);
        return null;
    }
}