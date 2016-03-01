object FileCall {
  def main(args: Array[String]) {
    val out = new FIO
    Console.println("What type is the file:")
    var input = Console.readLine.toUpperCase

    input match {
      case "CSV" | "ORACLE" | "EXCEL" => println("")
      case _ => println("Options available " +
        "csv, oracle, excel")
    }

    if (input == "CSV")
      out.csv
    if (input == "ORACLE")
      out.oracle
    if (input == "EXCEL")
      out.excel
  }
}
