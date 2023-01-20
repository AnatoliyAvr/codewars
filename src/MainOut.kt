fun main() {

    val messenger: Messenger<Message> = EmailMessenger()
    val message = messenger.writeMessage("Hello Kotlin")
    println(message.text)    // Email: Hello Kotlin
}

open class Message(val text: String)
class EmailMessage(text: String) : Message(text)

interface Messenger<out T : Message> {
    fun writeMessage(text: String): T
}

class EmailMessenger : Messenger<EmailMessage> {
    override fun writeMessage(text: String): EmailMessage {
        return EmailMessage("Email: $text")
    }
}