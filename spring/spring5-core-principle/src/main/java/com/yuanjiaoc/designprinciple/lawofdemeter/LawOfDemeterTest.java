package com.yuanjiaoc.designprinciple.lawofdemeter;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月15日
 */
public class LawOfDemeterTest {

  public static void main(String[] args) {

    Boss boss = new Boss();
    TeamLeader teamLeader = new TeamLeader();
    boss.commandCheckNumber(teamLeader);
  }
}
