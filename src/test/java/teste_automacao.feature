Feature: Testar Automacao
	Como um usuario
	Eu quero usar o Cucumber
	Para que eu possa automatizar os criterios de aceitacao

Scenario: 1 - Deve acessar o menu de navegacao Register e efetuar um registro
  Given que ao acessar o site "http://demo.automationtesting.in/Register.html"
  When executa-lo deve preencher o formulario
  Then o formulario deve ser enviado com sucesso

Scenario: 2 - Deve escrever dentro do frame
  Given que ao acessar o site "http://demo.automationtesting.in/Frames.html"
  When executa-lo deve escrever dentro do frame
  Then o frame deve receber o texto com sucesso

Scenario: 3 - Deve inserir data de nascimento nos dois campos
  Given que ao acessar o site "http://demo.automationtesting.in/Datepicker.html"
  When executa-lo deve inserir a data de nascimento nos dois campos
  Then a data de nascimento deve ser inserida com sucesso
@tag1
Scenario: 4 - Deve movimentar da barra em 50%
  Given que ao acessar o site "http://demo.automationtesting.in/Slider.html"
  When executa-lo a barra deve movimentar
  Then a barra deve ser movimentada com sucesso