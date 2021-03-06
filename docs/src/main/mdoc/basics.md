---
layout: tutorial
title: "Basics"
section: tutorial
sort_order: 0
---
There are a few concepts to get familiar with before getting to grips with kantan.xpath proper.

## Regular expression literals

First, xpath literals: xpath expressions that are validated at compile time. This is the preferred way
of creating xpath expressions and will be used throughout the documentation, so it's best to get that out of the way
as soon as possible.

There are various ways of enabling the feature, the simplest and most common one being to import
[`kantan.xpath.implicits._`]:

```scala mdoc:silent
import kantan.xpath.implicits._
```

This will also bring kantan.xpath syntax in scope though, so if you only want the literals, you can simply import
[`kantan.xpath.literals._`].

This lets you create new regular expression by prefixing string literals with [`xp`]:

```scala mdoc
xp"//a[@href]"
```

And, as promised, this fails *at compile time* if the xpath expression is not valid:

```scala mdoc:fail
xp"!@#"
```

## Simple evaluation

Subsequent pages will get into more details, but the simplest, most idiomatic way of extracting well typed data from
strings using kantan.xpath is through the [`evalXPath`] method that enriches strings (since we've imported
[`kantan.xpath.implicits._`]).

For example, retrieving only the first match:

```scala mdoc
"<users><user id='1'/><user id='2'/></users>".evalXPath[Int](xp"//user/@id")
```

And retrieving all matches:

```scala mdoc
"<users><user id='1'/><user id='2'/></users>".evalXPath[List[Int]](xp"//user/@id")
```

[`kantan.xpath.implicits._`]:{{ site.baseurl }}/api/kantan/xpath/implicits$.html
[`kantan.xpath.literals._`]:{{ site.baseurl }}/api/kantan/xpath/literals/index.html
[`evalXPath`]:{{ site.baseurl }}/api/kantan/xpath/ops/XmlSourceOps.html#evalXPath[B](expr:kantan.xpath.XPathExpression)(implicitevidence$2:kantan.xpath.Compiler[B],implicitsource:kantan.xpath.XmlSource[A]):kantan.xpath.XPathResult[B]
[`xp`]:{{ site.baseurl }}/api/kantan/xpath/literals/XPathLiteral.html#xp(args:Any*):kantan.xpath.XPathExpression
