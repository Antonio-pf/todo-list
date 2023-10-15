# API de To-Do List

Acesse a documentação completa da API para obter informações detalhadas sobre os endpoints e como usá-los aqui.


## Configuração de ambiente

Instalação JAVA 17

### Passo a passo

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

### Maven no Linux

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

### Endpoint de Criação de Usuário

- **URL:** `https://todolist-du65.onrender.com/users/`
- **Método:** POST
- **Descrição:** Este endpoint permite criar um novo usuário.

#### Exemplo de Requisição:

```http
POST https://todolist-du65.onrender.com/users/
Content-Type: application/json

{
    "name": "Tonho",
    "username": "tony",
    "password": "123456"
}
```

### Endpoint de Criação de Tarefa

- **URL:** `https://todolist-du65.onrender.com/tasks/`
- **Método:** POST
- **Descrição:** Este endpoint permite criar uma nova tarefa.

#### Exemplo de Requisição:

```http
POST https://todolist-du65.onrender.com/tasks/
Content-Type: application/json

{
    "description": "Teste",
    "title": "teste",
    "priority": "ALTA",
    "startAt": "2023-10-16T12:30:00",
    "endAt": "2023-10-16T16:30:00"  
}
```

### Endpoint de Listagem de Tarefas

- **URL:** `https://todolist-du65.onrender.com/tasks/`
- **Método:** GET
- **Descrição:** Este endpoint permite listar as tarefas de um usuário autenticado.

**Requisitos de Autenticação:**
- É necessário fornecer um nome de usuário e senha para acessar este endpoint.

**Exemplo de Requisição (com autenticação básica):**

```http
GET https://todolist-du65.onrender.com/tasks/
Authorization: Basic base64(username:password)
```

### Endpoint de Atualização de Tarefa

- **URL:** `http://localhost:8080/tasks/{taskId}`
- **Método:** PUT
- **Descrição:** Este endpoint permite atualizar uma tarefa existente.

**Requisitos de Autenticação:**
- É necessário estar autenticado para acessar este endpoint.

**Parâmetros:**
- `{id}`: O ID único da tarefa que deseja atualizar.

**Exemplo de Requisição (com autenticação):**

```http
PUT http://localhost:8080/tasks/0c13946e-ae9a-430e-8772-830913e33284
Authorization: Bearer seu_token_de_autenticacao
Content-Type: application/json

{
    "title": "Tarefa atualizada",
    "completed": true
}

