package com.example.whastsapp2.utils

import kotlin.random.Random

object Utils {
    val chats = mutableListOf(
        "Manuel" to mutableListOf(
            "Manuel: Hola Fernando, ¿cómo estás?",
            "Fernando: ¡Hola Manuel! Bien, ¿y tú?",
            "Manuel: Todo bien, gracias. ¿Qué planes tienes para el fin de semana?"
        ),
        "Fernando" to mutableListOf(
            "Fernando: Hola Sofía, ¿vamos al cine el sábado?",
            "Sofía: ¡Claro! ¿A qué hora?",
            "Fernando: ¿Te parece bien a las 7 pm?",
            "Sofía: Perfecto, nos vemos entonces."
        ),
        "Sofía" to mutableListOf(
            "Sofía: Manuela, ¿has terminado el proyecto?",
            "Manuela: Sí, lo envié ayer por la noche.",
            "Sofía: ¡Genial! ¡Gracias por tu ayuda!"
        ),
        "Manuela" to mutableListOf(
            "Manuela: Javier, ¿puedes ayudarme con la tarea de matemáticas?",
            "Javier: Claro, ¿qué necesitas?",
            "Manuela: No entiendo el problema 5.",
            "Javier: Vamos a revisarlo juntos."
        ),
        "Javier" to mutableListOf(
            "Javier: Hola Manuel, ¿has visto mi coche?",
            "Manuel: No, no lo he visto. ¿Lo perdiste?",
            "Javier: Sí, no lo encuentro por ningún lado.",
            "Manuel: Vamos a buscarlo juntos."
        ),
        "Ana" to mutableListOf(
            "Ana: Hola Carmen, ¿cómo va todo?",
            "Carmen: Todo bien, gracias. ¿Y tú?",
            "Ana: Bien también. ¿Te gustaría salir a tomar un café?",
            "Carmen: Sí, me encantaría."
        ),
        "Carmen" to mutableListOf(
            "Carmen: Jorge, ¿puedes ayudarme con el informe?",
            "Jorge: Claro, ¿qué necesitas?",
            "Carmen: Necesito revisar los datos.",
            "Jorge: Vamos a hacerlo juntos."
        ),
        "Jorge" to mutableListOf(
            "Jorge: Hola Luis, ¿cómo va el trabajo?",
            "Luis: Bien, pero estoy un poco estresado.",
            "Jorge: ¿Necesitas ayuda?",
            "Luis: Sí, me vendría bien."
        ),
        "Luis" to mutableListOf(
            "Luis: Hola Marta, ¿cómo te va?",
            "Marta: Bien, gracias. ¿Y tú?",
            "Luis: Estoy un poco cansado, pero bien.",
            "Marta: Cuídate y descansa."
        ),
        "Marta" to mutableListOf(
            "Marta: Hola Ana, ¿vamos a la playa este fin de semana?",
            "Ana: ¡Sí! Me encantaría.",
            "Marta: Perfecto, nos vemos el sábado.",
            "Ana: ¡Nos vemos!"
        ),
        "Carmen" to mutableListOf(
            "Carmen: Jorge, ¿puedes ayudarme con el informe?",
            "Jorge: Claro, ¿qué necesitas?",
            "Carmen: Necesito revisar los datos.",
            "Jorge: Vamos a hacerlo juntos."
        ),
        "Jorge" to mutableListOf(
            "Jorge: Hola Luis, ¿cómo va el trabajo?",
            "Luis: Bien, pero estoy un poco estresado.",
            "Jorge: ¿Necesitas ayuda?",
            "Luis: Sí, me vendría bien."
        ),
        "Luis" to mutableListOf(
            "Luis: Hola Marta, ¿cómo te va?",
            "Marta: Bien, gracias. ¿Y tú?",
            "Luis: Estoy un poco cansado, pero bien.",
            "Marta: Cuídate y descansa."
        ),
        "Marta" to mutableListOf(
            "Marta: Hola Ana, ¿vamos a la playa este fin de semana?",
            "Ana: ¡Sí! Me encantaría.",
            "Marta: Perfecto, nos vemos el sábado.",
            "Ana: ¡Nos vemos!"
        )
    )

    fun addMessage(name: String, message: String){

        var chat = findChat(name)
        chat.add("$name: $message")
    }
    fun findChat(name: String): MutableList<String> {
        return (chats.find { it.first == name }?.second ?: mutableListOf<String>())
    }

    fun hora(): String {
        var hora1 = Random.nextInt(0,24)
        var hora2 = Random.nextInt(0,60)
        if (hora1 < 10 && hora2 < 10) {return "0$hora1:0$hora2"}
        if (hora1 < 10 && hora2 >= 10) {return "0$hora1:$hora2"}
        if (hora1 > 10 && hora2 < 10) {return "$hora1:0$hora2"}
        else return "$hora1:$hora2"

    }

}