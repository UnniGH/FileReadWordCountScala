import scala.io.Source
import java.io.{FileReader, IOException, FileNotFoundException, PrintWriter}

class FIO {

  def csv{
    Console.println("Please provide the file details as 'C:\\Dir\\file.csv' format:")
    val input = Console.readLine.replace("\\","\\\\")
    val ft = input.lastIndexOf("\\")
    val output = input.replace(input.substring(ft + 1), "output.txt")
    val output2 = input.replace(input.substring(ft + 1), "count.txt")
    //try {
    //  val f = new FileReader(input)

      val source = Source.fromFile(input)
      val seq = new PrintWriter(output)
      val out = source.getLines.map(data => data.## -> data)
      seq.println(out.mkString)
      seq.close
      source.close

    /*}
      catch {
        case ex: FileNotFoundException => {
          println("Missing file exception")
        }
        case ex: IOException => {
          println("IO Exception")
        }
      }*/

    //val sep = lines.map(line => line.split(","))
    //sep.foreach(r => println(r.mkString("!!!")))
    val seq2 = new PrintWriter(output2)
    val source2 = Source.fromFile(input)
    val lines = source2.getLines().flatMap(_.split("\\W+")).toList.groupBy((word: String) => word).mapValues(_.length)
    for ((k,v) <- lines) seq2.println(k,v)
    //for ((k,v) <- lines) printf("%s - %s\n", k,v)
    seq2.close

    Console.println("Search a word to get count..")
    var input2 = Console.readLine
    val source3 = Source.fromFile(output2).getLines


    val ls = source3.find(_.startsWith("("+input2)).toString
    val res = ls.replace("Some((","").replace("))","")
    println("We got the count of word as:- " + res)
    val index = output.replace("\\\\","\\")
    val count = output2.replace("\\\\","\\")
    println("Please find the output fil with index at:-" + index)
    println("Please find the output fil with count of words at:-" + count)

  }

  def excel{
    println("Excel method is not yet defined")
  }

  def oracle{
  println("Oracle method is not yet defined")
  }


}



object run {
  def main(args: Array[String]) {

  }
}


