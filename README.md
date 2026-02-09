# FirebaseAuthTodoList

Este é um aplicativo de Lista de Tarefas para Android construído com Jetpack Compose, utilizando Firebase Authentication para gerenciamento de usuários e Firebase Realtime Database para armazenamento de dados. O aplicativo demonstra uma abordagem de arquitetura limpa usando MVVM (Model-View-ViewModel) e um padrão de repositório.

## Funcionalidades

*   **Autenticação de Usuário:** Registro e login seguros de usuários usando Firebase Authentication (e-mail/senha).
*   **Gerenciamento de Tarefas:**
    *   Visualize uma lista de suas tarefas pessoais.
    *   Adicione novas tarefas com título e descrição.
    *   Edite tarefas existentes.
    *   Marque tarefas como concluídas/não concluídas.
    *   Exclua tarefas.
*   **Armazenamento Persistente:** As tarefas são armazenadas no Google Cloud Firestore, garantindo a persistência dos dados entre sessões e dispositivos.

## Telas

O aplicativo é composto pelas seguintes telas principais:

1.  **Tela de Login (`LoginScreen.kt`):** Permite que usuários existentes façam login com e-mail e senha.
2.  **Tela de Cadastro (`SignupScreen.kt`):** Permite que novos usuários criem uma conta.
3.  **Tela da Lista de Tarefas (`ListScreen.kt`):** Exibe uma lista das tarefas do usuário autenticado. A partir daqui, os usuários podem adicionar novas tarefas, editar as existentes, marcá-las como concluídas ou excluí-las.
4.  **Tela Adicionar/Editar Tarefa (`AddEditScreen.kt`):** Um formulário para criar uma nova tarefa ou modificar uma existente.

## Decisões de Arquitetura

O projeto segue uma arquitetura modular e escalável:

*   **MVVM (Model-View-ViewModel):**
    *   **Model:** `TodoEntity.kt` (representação de dados para Firestore), `Todo.kt` (modelo de domínio).
    *   **View:** Componentes de UI do Jetpack Compose (`LoginScreen.kt`, `SignupScreen.kt`, `ListScreen.kt`, `AddEditScreen.kt`). Estes observam o estado do `ViewModel`.
    *   **ViewModel:** (`LoginViewModel.kt`, `SignupViewModel.kt`, `ListViewModel.kt`, `AddEditViewModel.kt`). Estes contêm dados e lógica relacionados à UI, interagindo com repositórios.
*   **Padrão Repositório:**
    *   `TodoRepository.kt` (interface que define operações de dados) e `TodoRepositoryImpl.kt` (implementação usando Firestore). Isso abstrai as fontes de dados dos `ViewModel`s.
    *   `FirebaseAuthRepository.kt`: Lida com todas as operações de autenticação do Firebase, fornecendo uma interface limpa para a lógica de autenticação.
*   **Navegação:** Usa Jetpack Compose Navigation (`TodoNavHost.kt`) para gerenciar a navegação entre as diferentes telas.
*   **Injeção de Dependências:** Usa implicitamente a injeção de construtor para `ViewModel`s e repositórios, facilitando testes e manutenibilidade.

## Tecnologias Utilizadas

*   **Kotlin:** Linguagem de programação principal.
*   **Jetpack Compose:** Kit de ferramentas moderno para UI do Android para construção de interfaces de usuário nativas.
*   **Firebase Authentication:** Para registro e login de usuários.
*   **Firebase Firestore:** Banco de dados em nuvem NoSQL para armazenar tarefas.
*   **Componentes de Arquitetura Android:** ViewModel, Navigation.
*   **Coroutines e Flow:** Para operações assíncronas e fluxos de dados reativos.