 <h1>Infopet - Sistema de Gerenciamento de Animais</h1>
    <p><strong>Infopet</strong> é um sistema completo para o gerenciamento de informações de animais. O projeto é dividido em duas partes principais: o Frontend, responsável pela interface gráfica com o usuário, e o Backend, que processa e armazena os dados dos animais. O objetivo do sistema é centralizar e organizar informações importantes, como o Registro Geral do Animal (RGA), histórico de consultas, vacinas, doenças, entre outros.</p>
    <h2>Estrutura do Projeto</h2>
    <p>O projeto está dividido em dois diretórios principais:</p>
    <ul>
        <li><strong>Backend:</strong> Desenvolvido em Java utilizando o framework Spring Boot e banco de dados MySQL. Ele é responsável por toda a lógica de negócios, persistência e integração com o banco de dados.</li>
        <li><strong>Frontend:</strong> Desenvolvido em React e Tailwind CSS. É a interface gráfica que será utilizada pelos usuários para interação com o sistema.</li>
    </ul>

<h2>Funcionalidades</h2>
<p>O sistema Infopet oferece diversas funcionalidades, focadas em facilitar o gerenciamento das informações dos animais:</p>
<ul>
    <li><strong>Cadastro de Animais:</strong> Registre os dados principais do animal, como nome, raça, data de nascimento, RGA, etc.</li>
    <li><strong>Histórico de Consultas:</strong> Armazene o histórico de consultas veterinárias do animal, com detalhes sobre o veterinário, data e diagnóstico.</li>
    <li><strong>Histórico de Vacinas:</strong> Gerencie as vacinas que o animal recebeu, incluindo tipo, data de aplicação e fabricante.</li>
    <li><strong>Registro de Doenças:</strong> Mantenha um histórico das doenças que o animal já teve e tratamentos realizados.</li>
</ul>

<h2>Tecnologias Utilizadas</h2>
<h3>Backend</h3>
<ul>
    <li><strong>Java 17</strong></li>
    <li><strong>Spring Boot 3.x:</strong> Framework que simplifica o desenvolvimento de aplicações Java robustas e escaláveis.</li>
    <li><strong>Spring Data JPA:</strong> Abstração para trabalhar com banco de dados relacionais usando ORM.</li>
    <li><strong>MySQL:</strong> Banco de dados relacional utilizado para armazenamento de dados.</li>
    <li><strong>Spring Security:</strong> Proverá a segurança do sistema, como autenticação e autorização (em desenvolvimento).</li>
</ul>

<h3>Frontend</h3>
<ul>
    <li><strong>React:</strong> Biblioteca JavaScript para construção de interfaces de usuário.</li>
    <li><strong>Tailwind CSS:</strong> Framework CSS utilitário para estilização rápida e responsiva.</li>
</ul>

<h2>Configuração do Projeto (Backend)</h2>

<h3>Requisitos</h3>
<ul>
    <li><strong>Java 17</strong> ou superior</li>
    <li><strong>Maven:</strong> Gerenciador de dependências</li>
    <li><strong>MySQL:</strong> Servidor de banco de dados</li>
</ul>

<h3>Passos para Configuração</h3>
<p>Siga os passos abaixo para configurar o backend do projeto:</p>

<h4>1. Clonar o Repositório:</h4>
    <pre><code>
git clone https://github.com/LincolnBarsotti/Pets
cd infopet/backend
</code></pre>

<h4>2. Configurar o Banco de Dados:</h4>
<p>Certifique-se de que o MySQL esteja rodando na sua máquina e crie um banco de dados chamado <code>infopet</code>. Em seguida, crie o arquivo <code>application.properties</code> localizado em <code>src/main/resources/</code> com suas credenciais do MySQL.</p>
<pre><code>
spring.datasource.url=jdbc:mysql://localhost:3306/infopet
spring.datasource.username=seu-usuario
spring.datasource.password=sua-senha
</code></pre>

<h4>3. Instalar Dependências e Rodar o Backend:</h4>
<p>No diretório raiz do backend, rode os seguintes comandos para instalar as dependências e iniciar o servidor:</p>
<pre><code>
mvn clean install
mvn spring-boot:run
</code></pre>
    <p>O backend estará disponível em <code>http://localhost:8080</code>.</p>

<h2>Contribuição</h2>
<p>Se você deseja contribuir com o projeto, siga estas etapas:</p>
<ol>
    <li>Faça um fork do repositório.</li>
    <li>Crie uma nova branch com sua feature: <code>git checkout -b minha-feature</code>.</li>
    <li>Faça commit de suas alterações: <code>git commit -m 'Minha nova feature'</code>.</li>
    <li>Envie para o repositório remoto: <code>git push origin minha-feature</code>.</li>
    <li>Crie um pull request.</li>
</ol>

<h2>Licença</h2>
<p>Este projeto está sob a licença <a href="https://opensource.org/licenses/MIT" target="_blank">MIT</a>. Sinta-se à vontade para utilizá-lo e modificá-lo de acordo com suas necessidades.</p>

<hr>

<p><strong>Autores:</strong><br>
 <a href="https://github.com/LincolnBarsotti" target="_blank">Lincoln Barsotti</a> Back-end <br>
<a href="https://github.com/danilobarros3" target="_blank">Danilo Barros</a> Front-end <br>
</p>