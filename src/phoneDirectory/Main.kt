package phoneDirectory

import phoneDirectory.PhoneDir.phone
import java.util.regex.Matcher
import java.util.regex.Pattern

object PhoneDir {

  fun phone(strng: String, num: String): String {
    var count = 0
    var j = 0

    val lines = strng.lines().filter { it.contains("+$num") }
    println(lines.single())

    val strArr = strng.split("\n")

    for (i in getPhone(strArr).indices) {
      if (getPhone(strArr)[i] == num) {
        count++
        j = i
      }
    }

    for (i in getPhone(strArr).indices) {
      if (count == 1) {
        return "Phone => ${getPhone(strArr)[j]}, Name => ${getName(strArr)[j]}, Address => ${getAddress(strArr)[j]}"
      } else if (count > 1) {
        return "Error => Too many people: $num"
      }
    }
    return "Error => Not found: $num"
  }
}

fun getPhone(phone: List<String>): List<String> {
  var str = ""
  val resultPhone = mutableListOf<String>()

  for (i in 0..phone.size - 2) {
    val matcher: Matcher = Pattern.compile("\\+\\d{1,2}-\\d{3}-\\d{3}-\\d{4}").matcher(phone[i])

    while (matcher.find()) str = matcher.group()
    resultPhone.add(str.substring(1))
  }

  return resultPhone
}

fun getName(name: List<String>): List<String> {
  val resultName = mutableListOf<String>()

  for (i in 0..name.size - 2) {
    resultName.add(name[i].substring(name[i].indexOf('<') + 1, name[i].indexOf('>')))
  }

  return resultName
}

fun getAddress(address: List<String>): List<String> {
  val resultAddress = mutableListOf<String>()

  for (i in 0..address.size - 2) {
    resultAddress.add(address[i]
        .replace(getPhone(address)[i], "")
        .replace(getName(address)[i], "")
        .replace("[_,!?:…<>*+;/$]".toRegex(), " ")
        .replace("    ", " ")
        .replace("   ", " ")
        .replace("  ", " ")
        .trim())
  }
  return resultAddress
}

fun main() {
  val dr = ("/+1-541-754-3010 156 Alphand_St. <J Steeve>\n 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010\n"
      + "<Anastasia> +48-421-674-8974 Via Quirinal Roma\n <P Salinger> Main Street, +1-098-512-2222, Denver\n"
      + "<Q Salinge> Main Street, +1-098-512-2222, Denve\n" + "<R Salinge> Main Street, +1-098-512-2222, Denve\n"
      + "<C Powel> *+19-421-674-8974 Chateau des Fosses Strasbourg F-68000\n <Bernard Deltheil> +1-498-512-2222; Mount Av.  Eldorado\n"
      + "<Peter O'Brien> High Street +1-908-512-2222; CC-47209\n")
  println(phone(dr, "1-498-512-2222"))
  println(phone(dr, "5-555-555-5555"))
}