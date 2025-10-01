import java.util.*

object Chatbot {
    // Dicionário de respostas
    private val respostas: MutableMap<String, String> = HashMap()

    @JvmStatic
    fun main(args: Array<String>) {
        // Carregar as respostas predefinidas
        carregarRespostas()


        // Criar um scanner para ler as mensagens do usuário
        val scanner = Scanner(System.`in`)
        println("Olá! Eu sou o chatbot. Como posso ajudar você hoje?")


        // Loop para continuar conversando com o usuário
        while (true) {
            print("Você: ")
            val mensagem = scanner.nextLine().lowercase(Locale.getDefault()).trim { it <= ' ' }

            if (mensagem == "sair" || mensagem == "adeus") {
                println("Chatbot: Até logo! Volte quando precisar.")
                break
            }


            // Resposta do chatbot
            val resposta = obterResposta(mensagem)
            println("Chatbot: $resposta")
        }

        scanner.close()
    }

    // Função para carregar as respostas predefinidas
    private fun carregarRespostas() {
        respostas["oi"] = "Olá! Como posso ajudar você hoje?"
        respostas["como vai"] = "Estou bem, obrigado! E você?"
        respostas["qual seu nome"] = "Eu sou um chatbot criado para ajudar!"
        respostas["adeus"] = "Até logo! Volte quando precisar."
        respostas["qual é a sua função"] = "Eu sou um assistente virtual que pode responder perguntas simples."
        respostas["o que você pode fazer"] =
            "Posso responder perguntas básicas, conversar e até ajudar com algumas dúvidas!"
        respostas["como você está"] = "Estou bem, obrigado por perguntar! E você?"
        respostas["me ajude"] = "Claro! Como posso ajudar você?"
    }

    // Função para obter uma resposta com base na mensagem recebida
    private fun obterResposta(mensagem: String): String? {
        // Verifica se a mensagem corresponde a alguma chave do mapa de respostas
        return if (respostas.containsKey(mensagem)) {
            respostas[mensagem]
        } else {
            "Desculpe, não entendi. Tente novamente."
        }
    }
}