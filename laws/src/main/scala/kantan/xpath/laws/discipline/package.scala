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

package kantan.xpath.laws

import kantan.codecs.laws._, CodecValue.{IllegalValue, LegalValue}
import kantan.codecs.laws.discipline.DecoderTests
import kantan.xpath._

package object discipline {
  type LegalNode[A]   = LegalValue[Option[Node], A, codecs.type]
  type IllegalNode[A] = IllegalValue[Option[Node], A, codecs.type]
  type NodeValue[A]   = CodecValue[Option[Node], A, codecs.type]

  type NodeDecoderLaws[A]  = DecoderLaws[Option[Node], A, DecodeError, codecs.type]
  type NodeDecoderTests[A] = DecoderTests[Option[Node], A, DecodeError, codecs.type]
}
