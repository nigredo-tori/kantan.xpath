package kantan.xpath

import kantan.xpath.laws.discipline.NodeDecoderTests
import kantan.xpath.laws.discipline.arbitrary._
import org.scalatest.FunSuite
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.typelevel.discipline.scalatest.Discipline

class EitherTests extends FunSuite with GeneratorDrivenPropertyChecks with Discipline {
  checkAll("NodeDecoder[Either[Int, Boolean]]", NodeDecoderTests[Either[Int, Boolean]].decoder[Int, Int])
}