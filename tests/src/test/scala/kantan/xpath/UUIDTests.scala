package kantan.xpath

import java.util.UUID

import kantan.xpath.laws.discipline.NodeDecoderTests
import kantan.xpath.laws.discipline.arbitrary._
import org.scalacheck.{Arbitrary, Gen}
import org.scalatest.FunSuite
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.typelevel.discipline.scalatest.Discipline

class UUIDTests extends FunSuite with GeneratorDrivenPropertyChecks with Discipline {
  implicit val arbUUID = Arbitrary(Gen.uuid)

  checkAll("NodeDecoder[UUID]", NodeDecoderTests[UUID].decoder[Int, Int])
}