package com.knoldus.server

import akka.http.scaladsl.testkit.{ScalatestRouteTest, WSProbe}
import org.scalatest.{Matchers, WordSpec}


class WebServerTest extends WordSpec with Matchers with ScalatestRouteTest with WebServer{

  "Websocket" should {
    "pull and push message" in {
      val wsClient = WSProbe()
      WS("/register?name=John", wsClient.flow) ~> route ~>
        check {
          // check response for WS Upgrade headers
          isWebSocketUpgrade shouldEqual true

          // manually run a WS conversation
          wsClient.sendMessage("How are you?")
          wsClient.expectMessage("John::How are you?")
        }
    }
  }
}
