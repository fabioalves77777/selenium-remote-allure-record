Existem duas maneiras para executar os scripts e gerar relatório:

1°) Pelo Maven Build

Passos:

1 - Clicar com o botão direito do mouse em cima do projeto > Run As > Run Configurations

2 - Clicar com o botão direito do mouse em cima do Maven build > New Configuration

3 - Preencher o campo name com "Maven Report Test" 

4 - Clicar no botão workspace e selecionar o projeto

5 - Preencher o campo Goals com "clean test allure:report" (Relatório só abre no Edge)

6 - Acionar a opção "Run"

Obs.: Caso queira ver o relatório em outros navegadores basta preencher o campo Goals com "clean test allure:serve" porém o relatório é somente apresentado, não é salvo. E no console do eclipse tem de encerrar o processo manualmente.

Outra forma e criar atalho do Chrome na área de trabalho > Acessar as propriedades do atalho > adicionar ao final do destino --disable-web-security --user-data-dir="c:/chromedev"

2°) Pelo prompt de comando

Passos:

1 - Abrir o prompt de comando e acessar a pasta raiz do projeto;

2 - Na raiz do projeto, executar o seguinte comando para executar os testes e gerar relatório: mvn clean test allure:report

SELENIUM GRID

1°) Registrar HUB

Passos:

1 - Abrir prompt de comando no caminho: {PROJETO}/selenium-grid

2 - Digitar o comando: java -jar selenium-grid.jar -role hub -hubConfig hubConfig.json -debug

2°) Registrar NODE

1 - Abrir prompt de comando no caminho: {PROJETO}/selenium-grid

2 - Digitar o comando: java -Dwebdriver.gecko.driver=./drivers/geckodriver.exe -Dwebdriver.chrome.driver=./drivers/chromedriver_79.exe -jar selenium-grid.jar -role node -nodeConfig nodeConfig.json
