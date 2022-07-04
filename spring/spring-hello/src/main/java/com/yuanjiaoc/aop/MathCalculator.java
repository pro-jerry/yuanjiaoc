package com.yuanjiaoc.aop;

import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月04日
 */
@Component
public class MathCalculator {

	public int div(int i, int j) {
		return i / j;
	}
}
