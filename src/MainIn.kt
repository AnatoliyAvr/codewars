fun main() {

    val messenger: MessengerIn<EmailMessageIn> = InstantMessengerIn() // InstantMessenger - это Messenger<Message>
    val message = EmailMessageIn("Hi Kotlin")
    messenger.sendMessageIn(message)
}

open class MessageIn(val text: String)
class EmailMessageIn(text: String) : MessageIn(text)

interface MessengerIn<in T : MessageIn> {
    fun sendMessageIn(message: T)
}

class InstantMessengerIn : MessengerIn<MessageIn> {
    override fun sendMessageIn(message: MessageIn) {
        println("Send message: ${message.text}")
    }
}