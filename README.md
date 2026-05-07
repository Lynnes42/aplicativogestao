Sistema de Gestão de Chamados

Este projeto é um aplicativo Android desenvolvido em Java para a gestão de incidentes e solitações de manutenção (TI e infraestrutura) dentro de uma empresa. O sistema permite o ciclo de vida completo de um chamado: desde de sua abertura pelo usuário até a resolução e fechamento pelo prestador de serviço.
Funcionalidades

    Dashboard Principal: Visualização rápida do total de chamados em aberto e navegação simplificada;

    Abertura de Chamados: Cadastro de novos problemas com título, descrição, local (Blocos) e categoria (TI ou infraestrutura);

    Listagem Inteligente: Visualização de todos os chamados com filtros por status (aberto, Em Atendimento, Concluído) e diferenciação visual por cores;

    Gestão de Atendimento: Tela dedicada para o prestador de serviço inserir a solução técnica e atualizar o status do chamado;

    Banco de Dados Local: Persistência de dados utilizando a biblioteca Room (SQLite), garantindo que as informações não sejam perdidas ao fechar o app.

Interface e Experiência do Usuário

O aplicativo utiliza componentes do Material Design, garantindo uma Interface limpa e intuitiva:

    Cores indicativas: No sistema de listagem, os chamados são identificados visualmente:

        🔴 Vermelho: Aberto;

        🟡 Amarelo: Em Atendimento;

        🟢 Verde: Concluído.

    Navegação: Todas as telas secundárias possuem botões de retorno rápido ao menu principal.

Tecnologias Utilizadas

    Linguagem: Java

    Android SDK: Ferramentas nativas para interface e lógica.

    Google Material Design: Para botões, campos de texto (TextInputEditText) e Chips de filtragem

    Room Database: Persistência de dados local (camada de abstração sobre o SQLite)

    Recycler View: Para exibição eficiente de listas de chamados

    Adapter Pattern: Para gerenciamento dinâmico dos dados na interface.

Estrutura do Projeto(Activity)

MainActivity: Atua como o centro de comando. Exibe o contador de chamados abertos e direciona para as outras funções;

CadastroActivity: Formulário de entrada para novos incidentes, capturando automaticamente a data atual;

ListagemActivity: Exibe a lista de chamados com suporte a filtros dinâmicos através de ChipGroup;

AtendimentoActivity: Interface de edição onde o técnico registra a solução e finaliza o ticket.
