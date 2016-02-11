---
layout: default
---

[![Build Status](https://travis-ci.org/nrinaudo/kantan.xpath.svg)](https://travis-ci.org/nrinaudo/kantan.xpath)
[![codecov.io](http://codecov.io/github/nrinaudo/kantan.xpath/coverage.svg)](http://codecov.io/github/nrinaudo/kantan.xpath)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.nrinaudo/kantan.xpath_2.11/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.nrinaudo/kantan.xpath_2.11)
[![Join the chat at https://gitter.im/nrinaudo/kantan.xpath](https://img.shields.io/badge/gitter-join%20chat-52c435.svg)](https://gitter.im/nrinaudo/kantan.xpath)

kantan.xpath is an XPath expression evaluation library for the [Scala programming language](http://www.scala-lang.org).

## Getting started

kantan.xpath is currently available both for Scala 2.10 and 2.11.

The current version is `0.1.0`, which can be added to your project with one or more of the following line(s)
in your SBT build file:

```scala
// Core library, included automatically if any other module is imported.
libraryDependencies += "com.nrinaudo" %% "kantan.xpath" % "0.1.0"

// Provides scalaz type class instances.
libraryDependencies += "com.nrinaudo" %% "kantan.xpath-scalaz" % "0.1.0"

// Provides cats type class instances.
libraryDependencies += "com.nrinaudo" %% "kantan.xpath-cats" % "0.1.0"

// Provides "dirty" HTML parsing through NekoHTML.
libraryDependencies += "com.nrinaudo" %% "kantan.xpath-nekohtml" % "0.1.0"
```

## Motivation

Web scrapping is something that I have to do with some regularity, and the standard Scala XML library is not well suited
for that task - not as well, at least, as a proper XPath implementation.

The standard Java library, on the other hand, has an acceptably efficient XPath API, but one that is hobbled, from a
Scala perspective, by terrible types and safety issues. Everything throws and everything is a node.

kantan.xpath, then, is a thin layer over that Java API that attempts to provide much needed safety, useful types
and as much boilerplate removal as possible.

## Tutorials

The following tutorials are available:
{% for x in site.tut %}
{% if x.status != "wip" and x.section == "tutorial" %}
* [{{ x.title }}]({{ site.baseurl }}{{ x.url }})
{% endif %}
{% endfor %}