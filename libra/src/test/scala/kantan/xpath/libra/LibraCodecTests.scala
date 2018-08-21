/*
 * Copyright 2016 Nicolas Rinaudo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package kantan.xpath
package libra

import _root_.libra.Quantity
import arbitrary._
import laws.discipline._
import shapeless.HNil

class LibraCodecTests extends DisciplineSuite {

  checkAll("NodeDecoder[Quantity[Double, HNil]]", SerializableTests[NodeDecoder[Quantity[Double, HNil]]].serializable)
  checkAll("NodeDecoder[Quantity[Double, HNil]]", NodeDecoderTests[Quantity[Double, HNil]].decoder[String, Float])

  checkAll("NodeDecoder[Quantity[Int, HNil]]", SerializableTests[NodeDecoder[Quantity[Int, HNil]]].serializable)
  checkAll("NodeDecoder[Quantity[Int, HNil]]", NodeDecoderTests[Quantity[Int, HNil]].decoder[String, Float])

}