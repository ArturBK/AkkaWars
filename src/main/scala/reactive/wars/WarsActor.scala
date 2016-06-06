package reactive.wars

import reactive.websocket.WebSocket
import akka.actor.{Actor, ActorLogging, Props}
import reactive.scan.ScanPlanetActor


object WarsActor {
  sealed trait HideMessage
  case object Clear extends HideMessage
  case class Unregister(ws : WebSocket) extends HideMessage
}

class WarsActor extends Actor with ActorLogging {
  val ScanPlanet = context.actorOf(Props[ScanPlanetActor])

  override def receive = {
    case "a" => {
      ScanPlanet ! "a"
    }
  }
}