import com.alibaba.csp.sentinel.slots.block.BlockException
import com.alibaba.csp.sentinel.{Entry, SphU}

object SimpleTest1 extends App {

  def rules = {
    import com.alibaba.csp.sentinel.slots.block.RuleConstant
    import com.alibaba.csp.sentinel.slots.block.flow.FlowRule
    import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager
    import java.util
    val rules = new util.ArrayList[FlowRule]
    val rule = new FlowRule
    rule.setResource("HelloWorld")
    rule.setGrade(RuleConstant.FLOW_GRADE_QPS)
    // Set limit QPS to 20.
    rule.setCount(20)
    rules.add(rule)
    FlowRuleManager.loadRules(rules)
  }


  rules

  while (true){

    var entry : Entry = null
    try {
      entry = SphU.entry("test")
      println ("ok----")
    } catch {
      case _ : BlockException => println ("block!")
      case _ => println ("ex")
    } finally {
      Option.apply(entry).foreach(_.exit())
    }
  }


}
