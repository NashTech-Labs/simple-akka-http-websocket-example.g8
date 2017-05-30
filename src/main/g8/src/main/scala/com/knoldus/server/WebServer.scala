package com.knoldus.server

import akka.http.scaladsl.model.ws.{Message, TextMessage}
import akka.http.scaladsl.server.Directives
import akka.stream.scaladsl.{Flow, Source}


trait WebServer extends Directives {

  def route =
    path("register") {
      parameter('name) { name ⇒
        handleWebSocketMessages(broadcast(name))
      }
    }

  def broadcast(name: String): Flow[Message, Message, Any] = {
    Flow[Message].mapConcat {
      case tm: TextMessage =>
        TextMessage(Source.single(name+"::") ++ tm.textStream) :: Nil
    }

  }
}
