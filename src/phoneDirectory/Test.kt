package phoneDirectory

import java.util.regex.Pattern
import org.junit.Test
import kotlin.test.assertEquals

class PhoneDirTest {
  private fun testing(actual: String, expected: String) {
    assertEquals(expected, actual)
  }
  val dr = ("/+1-541-754-3010 156 Alphand_St. <J Steeve>\n 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010\n"
      + "<Anastasia> +48-421-674-8974 Via Quirinal Roma\n <P Salinger> Main Street, +1-098-512-2222, Denver\n"
      + "<Q Salinge> Main Street, +1-098-512-2222, Denve\n" + "<R Salinge> Main Street, +1-098-512-2222, Denve\n"
      + "<C Powel> *+19-421-674-8974 Chateau des Fosses Strasbourg F-68000\n <Bernard Deltheil> +1-498-512-2222; Mount Av.  Eldorado\n")
  @Test
  fun test1() {
    testing(
        PhoneDir.phone(dr, "48-421-674-8974"),
        "Phone => 48-421-674-8974, Name => Anastasia, Address => Via Quirinal Roma"
    )
    testing(
        PhoneDir.phone(dr, "19-421-674-8974"),
        "Phone => 19-421-674-8974, Name => C Powel, Address => Chateau des Fosses Strasbourg F-68000"
    )
    testing(PhoneDir.phone(dr, "1-098-512-2222"), "Error => Too many people: 1-098-512-2222")
    testing(PhoneDir.phone(dr, "5-555-555-5555"), "Error => Not found: 5-555-555-5555")

  }
}