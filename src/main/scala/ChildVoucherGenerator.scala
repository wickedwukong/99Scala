import org.joda.time.format.{DateTimeFormatter, DateTimeFormat}
import org.joda.time.DateTime
import org.stringtemplate.v4.ST

object ChildVoucherGenerator extends App {

  def loadFile(filePath: String) = {
    """<html><span>$date$</span></html>"""
  }



  def generate(tempaltePath: String, startingMonthString: String, numberOfVouchers: Int, destinationPath: String) = {

    var voucherTemplate = loadFile(tempaltePath)

    val pattern: DateTimeFormatter = DateTimeFormat.forPattern("yyyyMM")
    val date: DateTime = pattern.parseDateTime(startingMonthString)

    val st: ST = new ST(voucherTemplate, '$', '$')

    st.add("date", pattern.print(date))

    st.render()

  }

  val generate: String = generate("templatePath", "201302", 2, "destinationPath")

  println("xxxxx" + generate)



}
