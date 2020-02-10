package phoneDirectory

import phoneDirectory.PhoneDir.phone
import phoneDirectory.PhoneDir.reg

object PhoneDir {

  const val reg = "\\+\\d{1,2}-\\d{3}-\\d{3}-\\d{4}"
  //^\d{1,2}\-\d{3}\-\d{3}\-\d{4}$

  fun phone(strng: String, num: String): String {
    var name = ""
    var adress = ""

    val a = strng.split("\n")
    var b : List<String> = listOf()
    for (i in a) {
       b = i.split(reg.toRegex())

    }

    for (i in b!!){
      println(i)
    }

    return "Phone => $num, Name => $name, Address => $adress"
    return "Error => Too many people: $num"
    return "Error => Not found: $num"
  }
}


fun main() {
  val dr = ("/+1-541-754-3010 156 Alphand_St. <J Steeve>\n 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010\n"
      + "<Anastasia> +48-421-674-8974 Via Quirinal Roma\n <P Salinger> Main Street, +1-098-512-2222, Denver\n"
      + "<Q Salinge> Main Street, +1-098-512-2222, Denve\n" + "<R Salinge> Main Street, +1-098-512-2222, Denve\n"
      + "<C Powel> *+19-421-674-8974 Chateau des Fosses Strasbourg F-68000\n <Bernard Deltheil> +1-498-512-2222; Mount Av.  Eldorado\n")
  phone(dr, "48-421-674-8974")

}