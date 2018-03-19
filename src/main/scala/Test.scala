import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext

object Test {
  val sc = new SparkContext()
  val sqlContext = new SQLContext(sc)
  def f = 1

}
