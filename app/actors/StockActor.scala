package actors

import akka.actor._
import java.time.ZonedDateTime
import yahoofinance._
import play.api.Logging
import scala.util.parsing.json.JSON

object StockActor {
  def props(out: ActorRef) = Props(new StockActor(out))
}

case object PollMessage

class StockActor(out: ActorRef) extends Actor with Logging {
  private var stockSymbol = ""
  def receive = {
    case PollMessage => {
      try {
        val stock = YahooFinance.get(stockSymbol);
        val price = stock.getQuote(true).getPrice();
        out ! ("{\"price\":\""+price.toString() + "\"}")
      } catch {
        case e: Exception => { 
          logger.error(e.toString())
          out ! ("{\"status\":\"Error while requesting stock information\"}")
        }
      }
      Thread.sleep(1000)
      self ! PollMessage
    }
    case msg: String =>
      out ! ("{\"status\":\"Starting stock stream\"}")
      logger.info("Pass in value " + msg.trim());
      val data = JSON.parseFull(msg.trim())
      data match {
        case Some(map: Map[String, String]) => {
          try {
            stockSymbol = map("symbol")
            self ! PollMessage
          }
          catch {
            case e: NoSuchElementException => {
              logger.error(e.toString())
            }
          }
        }
        case None => logger.debug("Parsing failed")
        case other => logger.info("Unknown data structure: " + other)
      }
   }
}
