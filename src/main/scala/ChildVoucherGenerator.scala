import collection.immutable.IndexedSeq
import io.{BufferedSource, Source}
import java.io.{PrintWriter, FileInputStream, File}
import org.joda.time.format.{DateTimeFormatter, DateTimeFormat}
import org.joda.time.DateTime
import org.stringtemplate.v4.ST

object ChildVoucherGenerator extends App {

  def loadFile(filePath: String) = {
//    """<html><span>$date$</span></html>"""


    val file: BufferedSource = Source.fromInputStream(new FileInputStream(new File(filePath)),"UTF-8")
    val string: String = file.mkString
    file.close()
    string
  }



  def generate(templatePath: String, startingMonthString: String, numberOfVouchers: Int, destinationPath: String) = {

    var voucherTemplate = loadFile(templatePath)
    val startingMonth: DateTime = DateTimeFormat.forPattern("yyyyMM").parseDateTime(startingMonthString)


    (0 to (numberOfVouchers - 1)).map(x => {
      val st: ST = new ST(voucherTemplate, '$', '$')

      val voucherMonth: String = DateTimeFormat.forPattern("yyyyMM").print(startingMonth.plusMonths(x))
      st.add("voucherMonth", voucherMonth)
      val voucher: String = st.render()
      val writer: PrintWriter = new PrintWriter(new File(destinationPath + "ChildcareVoucher-" + voucherMonth + ".html"), "UTF-8")

      try {
        writer.print(voucher)
      }
      finally {
        writer.close()
      }

    })



  }

  val destinationPath: String = "/Users/wickedwukong/Dropbox/company/childcare-vouchers/2013/unused/"
  generate("/Users/wickedwukong/Dropbox/company/childcare-vouchers/2013/unused/ChildcareVoucher-template.htm", "201402", 12, destinationPath)


  println("done! voucher generated in " + destinationPath)



}
