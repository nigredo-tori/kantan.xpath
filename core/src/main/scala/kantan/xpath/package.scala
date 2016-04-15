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

package kantan

import kantan.codecs.{Decoder, Result}

package object xpath {
  type NodeDecoder[A] = Decoder[Node, A, DecodeError, codecs.type]
  type SafeExpression[A] = Expression[DecodeResult[A]]


  // - Result types ----------------------------------------------------------------------------------------------------
  // -------------------------------------------------------------------------------------------------------------------
  type ReadResult[A] = Result[ReadError, A]
  type DecodeResult[A] = Result[DecodeError, A]
  type ParseResult = Result[ParseError, Node]



  // - XML types -------------------------------------------------------------------------------------------------------
  // -------------------------------------------------------------------------------------------------------------------
  type Element = org.w3c.dom.Element
  type Node = org.w3c.dom.Node
  type Document = org.w3c.dom.Document
  type Attr = org.w3c.dom.Attr
  type NodeList = org.w3c.dom.NodeList
}
