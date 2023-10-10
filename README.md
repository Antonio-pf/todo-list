# Getting Started

### Reference Documentation



### Configuração de ambiente

No linux instalação JAVA 17

#### Passo a passo

1 - Abrir um terminal (CTRL + ALT + T)

2 - Digitar o seguinte comando 
```BASH
sudo add-apt-repository ppa:linuxuprising/java
```
Aceitar os termos, apertando ENTER


3 - Atualizar o gerenciador de pacotes
```BASH
sudo apt-get update
```

4 - Instalar o Java 17
```bash
sudo apt-get install oracle-java17-installer --install-recommends
```

5 - Pra ter certeza se o Java está instalado, digite:
```bash 
java -version 
```

#### Maven no Linux

1-  Atualize os pacotes
```bash 
sudo apt-get update
```

2 - Instale o maven com o seguinte comando
```bash
sudo apt-get -y install maven
```

O maven deverá ser instalado em um dos seguintes caminhos /usr/share/maven
 ou /etc/maven
.

Para verificar se o maven foi instalado com sucesso, acessar o terminar e digitar
```bash
mvn -version
```

Isso irá mostrar a versão do maven instalada.

