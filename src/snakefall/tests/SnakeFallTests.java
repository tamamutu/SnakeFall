// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package snakefall.tests;

import snakefall.Game;
import snakefall.io.*;
import snakefall.io.GameError;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SnakeFallTests {

	/**
	 * ============================================================
	 * Part 1 --- Basic Moves and Obstructions
	 * ============================================================
	 */

	@Test
	public void test_01() {
		// Check snake can move one step up
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|     OA   ###  |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "U";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|     O         |\n" +
				"2|     A    ###  |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";


		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_02() {
		// Check snake can move one step down
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|         OA    |\n" +
				"2|          ###  |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "D";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|         A     |\n" +
				"2|         O###  |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";


		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_03() {
		// Check snake can move one step left
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|     OA   ###  |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "L";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|    OA    ###  |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";


		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_04() {
		// Check snake can move one step right
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|     AO   ###  |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "R";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|      AO  ###  |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";


		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_05() {
		// Check snake can move two steps up
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|    BAO   ###  |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "UU";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|      O        |\n" +
				"3|      A        |\n" +
				"2|      B   ###  |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";


		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_06() {
		// Check snake can move two steps down
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|        OAB    |\n" +
				"3|         ###   |\n" +
				"2|         #    |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "DD";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|        B      |\n" +
				"3|        A###   |\n" +
				"2|        O#     |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";


		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_07() {
		// Check snake can move two steps left
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|         AB    |\n" +
				"2|         O###  |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LL";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|       OAB###  |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";


		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_08() {
		// Check snake can move two steps right
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|         AO    |\n" +
				"2|         B###  |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "RR";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|          BAO  |\n" +
				"2|          ###  |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";


		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_09() {
		// Check snake can move in longer sequence
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|          OABC |\n" +
				"2|          ###D |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LDLLUU";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|       O       |\n" +
				"3|       A       |\n" +
				"2|       BCD###  |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";


		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_10() {
		// Check snake can move in longer sequence
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|       OABCD   |\n" +
				"1|    #########  |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "UULDD";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|      BC       |\n" +
				"3|      AD       |\n" +
				"2|      O        |\n" +
				"1|    #########  |\n" +
				"0|               |\n" +
				"  012345678901234";


		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_11() {
		// Check snake obstructs itself (up)
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|      DCB      |\n" +
				"2|       OA      |\n" +
				"1|    #########  |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "R";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|      DCB      |\n" +
				"2|       OA      |\n" +
				"1|    #########  |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_12() {
		// Check snake obstructs itself (down)
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|       AO      |\n" +
				"2|       BCD     |\n" +
				"1|    #########  |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "D";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|       AO      |\n" +
				"2|       BCD     |\n" +
				"1|    #########  |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_13() {
		// Check snake obstructs itself (left)
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|      AO       |\n" +
				"1|    #########  |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "L";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|      AO       |\n" +
				"1|    #########  |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_14() {
		// Check snake obstructs itself (right)
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|       OAB     |\n" +
				"1|    #########  |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "R";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|       OAB     |\n" +
				"1|    #########  |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_15() {
		// Check earth obstructs snake (up)
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|       #       |\n" +
				"2|       OA      |\n" +
				"1|    #########  |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "U";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|       #       |\n" +
				"2|       OA      |\n" +
				"1|    #########  |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_16() {
		// Check earth obstructs snake (down)
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|       OA      |\n" +
				"1|    #########  |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "D";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|       OA      |\n" +
				"1|    #########  |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_17() {
		// Check earth obstructs snake (left)
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|    ###OA      |\n" +
				"1|    #########  |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "L";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|    ###OA      |\n" +
				"1|    #########  |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_18() {
		// Check earth obstructs snake (right)
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|       O#      |\n" +
				"1|    #########  |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "R";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|       O#      |\n" +
				"1|    #########  |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_19() {
		// Check snake doesn't obstruct snake (clockwise)
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|       CB      |\n" +
				"2|       OA      |\n" +
				"1|    #########  |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "U";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|       CB      |\n" +
				"2|       OA      |\n" +
				"1|    #########  |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_20() {
		// Check snake doesn't obstruct snake (anti-clockwise)
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|       AB      |\n" +
				"2|       OC      |\n" +
				"1|    #########  |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "R";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|       AB      |\n" +
				"2|       OC      |\n" +
				"1|    #########  |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	/**
	 * ============================================================
	 * Part 2 --- Lengthening
	 * ============================================================
	 */

	@Test
	public void test_21() {
		// Check snake lengthens (up)
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|     *         |\n" +
				"2|     OA   ###  |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "U";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|     O         |\n" +
				"2|     AB   ###  |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_22() {
		// Check snake lengthens (down)
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|     OA        |\n" +
				"2|     *         |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "D";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|     AB        |\n" +
				"2|     O         |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_23() {
		// Check snake lengthens (left)
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|    *OAB       |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "L";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|    OABC       |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_24() {
		// Check snake lengthens (right)
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|     BAO*      |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "R";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|     CBAO      |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_25() {
		// Check snake lengthens twice
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|     *         |\n" +
				"3|     *         |\n" +
				"2|     OA   ###  |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "UU";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|     O         |\n" +
				"3|     A         |\n" +
				"2|     BC   ###  |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_26() {
		// Check snake lengthens thrice
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|   *            |\n" +
				"2|   #**OA       |\n" +
				"1|   #######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LLUL";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|   OA          |\n" +
				"2|   #BCD        |\n" +
				"1|   #######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	/**
	 * ============================================================
	 * Part 3 --- Gravity
	 * ============================================================
	 */

	@Test
	public void test_27() {
		// Check snake cannot move up
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|     O         |\n" +
				"2|     A    ###  |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "U";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|     O         |\n" +
				"2|     A    ###  |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_28() {
		// Check snake falls down (left)
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|          OA   |\n" +
				"2|          ###  |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LL";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|        OA###  |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_29() {
		// Check snake falls down (right)
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|  BAO          |\n" +
				"2| ###           |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "RR";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2| ###BAO        |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_30() {
		// Check snake falls down (down)
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|   AO          |\n" +
				"3|  ###          |\n" +
				"2|    #          |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "RD";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|  ###A         |\n" +
				"2|    #O         |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_31() {
		// Check snake falls down (left)
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|          OA   |\n" +
				"3|          #    |\n" +
				"2|          #    |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LL";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|          #    |\n" +
				"2|        OA#    |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_32() {
		// Check snake falls down (right)
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|  BAO          |\n" +
				"4|    #          |\n" +
				"3|    #          |\n" +
				"2|    #          |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "RRR";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|    #          |\n" +
				"3|    #          |\n" +
				"2|    #BAO       |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_33() {
		// Check snake falls down (down)
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|  BAO          |\n" +
				"4|    #          |\n" +
				"3|    #          |\n" +
				"2|    #          |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "RRD";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|    #          |\n" +
				"3|    #BA        |\n" +
				"2|    # O        |\n" +
				"1|    ######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_34() {
		// Check snake falls down (left)
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|          OAB  |\n" +
				"3|           #   |\n" +
				"2|               |\n" +
				"1|          #    |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LL";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|           #   |\n" +
				"2|        OAB    |\n" +
				"1|          #    |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_35() {
		// Check snake falls down (left)
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|          OAB  |\n" +
				"3|           #   |\n" +
				"2|               |\n" +
				"1|         #     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LL";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|           #   |\n" +
				"2|        OAB    |\n" +
				"1|         #     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_36() {
		// Check snake falls down (left)
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|          OAB  |\n" +
				"3|           #   |\n" +
				"2|               |\n" +
				"1|        #      |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LL";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|           #   |\n" +
				"2|        OAB    |\n" +
				"1|        #      |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_37() {
		// Check snake lands on "power up" pill
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|          OAB  |\n" +
				"3|           #   |\n" +
				"2|               |\n" +
				"1|        *      |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LL";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|           #   |\n" +
				"2|        OAB    |\n" +
				"1|        *      |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_38() {
		// Check snake lands on "power up" pill
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|          OAB  |\n" +
				"3|           #   |\n" +
				"2|               |\n" +
				"1|         *     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LL";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|           #   |\n" +
				"2|        OAB    |\n" +
				"1|         *     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_39() {
		// Check snake lands on "power up" pill
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|          OAB  |\n" +
				"3|           #   |\n" +
				"2|               |\n" +
				"1|          *    |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LL";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|           #   |\n" +
				"2|        OAB    |\n" +
				"1|          *    |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_40() {
		// Check snake lands on "power up" pill
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|          OA    |\n" +
				"4|           #   |\n" +
				"3|           #   |\n" +
				"2|          *#   |\n" +
				"1|       #####   |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "DD";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|          B#   |\n" +
				"3|          A#   |\n" +
				"2|          O#   |\n" +
				"1|       #####   |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	/**
	 * ============================================================
	 * Part 4 --- Game Over
	 * ============================================================
	 */

	@Test
	public void test_41() {
		// Check game won if target reached
		String startingBoard =
				"7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|       @ OA    |\n" +
				"1|       #####   |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LL!";

		String finalBoard =
				"7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|       OA      |\n" +
				"1|       #####   |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_42() {
		// Check game won if target reached
		String startingBoard =
				"7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|        @      |\n" +
				"3|          B    |\n" +
				"2|         OA    |\n" +
				"1|       #####   |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LUU!";

		String finalBoard =
				"7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|        O      |\n" +
				"3|        A      |\n" +
				"2|        B      |\n" +
				"1|       #####   |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_43() {
		// Check game won if fall through target
		String startingBoard =
				"7|               |\n" +
				"6|        OA     |\n" +
				"5|         ###   |\n" +
				"4|               |\n" +
				"3|       @       |\n" +
				"2|               |\n" +
				"1|       #####   |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "L!";

		String finalBoard =
				"7|               |\n" +
				"6|               |\n" +
				"5|         ###   |\n" +
				"4|               |\n" +
				"3|       OA      |\n" +
				"2|               |\n" +
				"1|       #####   |\n" +
				"0|               |\n" +
				"  012345678901234";
		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_44() {
		// Check game won if fall through target
		String startingBoard =
				"7|               |\n" +
				"6|    BAO        |\n" +
				"5|    ###        |\n" +
				"4|               |\n" +
				"3|       @       |\n" +
				"2|               |\n" +
				"1|               |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "RDD!";

		String finalBoard =
				"7|               |\n" +
				"6|               |\n" +
				"5|    ###B       |\n" +
				"4|       A       |\n" +
				"3|       O       |\n" +
				"2|               |\n" +
				"1|               |\n" +
				"0|               |\n" +
				"  012345678901234";
		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_45() {
		// Check game lost if fall off end of board
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|     OA        |\n" +
				"1|     #####     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LL?";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|               |\n" +
				"1|     #####     |\n" +
				"0|               |\n" +
				"  012345678901234";
		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_46() {
		// Check game lost if partially fall off end of board
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|     OABCD     |\n" +
				"1|     #####     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LDDD?";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|    CD         |\n" +
				"1|    B#####     |\n" +
				"0|    A          |\n" +
				"  012345678901234";
		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_47() {
		// Check game lost if partially fall off end of board
		String startingBoard =
				"7|               |\n" +
				"6| @       OA    |\n" +
				"5|          B    |\n" +
				"4|        # CD   |\n" +
				"3|           #   |\n" +
				"2|               |\n" +
				"1|               |\n" +
				"0|     #####     |\n" +
				"  012345678901234";

		String sequence = "U?";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|        #      |\n" +
				"3|           #   |\n" +
				"2|         O     |\n" +
				"1|         AB    |\n" +
				"0|     #####C    |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_48() {
		// Check invalid game win if target not reached
		String startingBoard =
				"7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|       @ OA    |\n" +
				"1|       #####   |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "L!";
		//
		checkInvalid(sequence,startingBoard);
	}

	@Test
	public void test_49() {
		// Check invalid game lost if target reached
		String startingBoard =
				"7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|       @ OA    |\n" +
				"1|       #####   |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LL?";
		//
		checkInvalid(sequence,startingBoard);
	}

	@Test
	public void test_50() {
		// Check invalid game lost if game on going
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|     OA        |\n" +
				"1|     #####     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "L?";

		checkInvalid(sequence,startingBoard);
	}

	@Test
	public void test_51() {
		// Check invalid game lost if game won!
		String startingBoard =
				"7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|     @OA       |\n" +
				"1|     #####     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "L?";

		checkInvalid(sequence,startingBoard);
	}

	/**
	 * ============================================================
	 * Part 5 --- Girders
	 * ============================================================
	 */

	@Test
	public void test_52() {
		// Check smallest girder possible
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|  AO N         |\n" +
				"1|  B#######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "RR";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|   BAON        |\n" +
				"1|   #######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_53() {
		// Check smallest girder possible
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|   N           |\n" +
				"2|  AO           |\n" +
				"1|  B#######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "U";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|   N           |\n" +
				"3|   O           |\n" +
				"2|  BA           |\n" +
				"1|   #######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_54() {
		// Check smallest girder possible
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|     N  OA     |\n" +
				"1|   #######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LLLL";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|   NOA         |\n" +
				"1|   #######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_55() {
		// Check smallest girder possible
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|       N       |\n" +
				"3|      OA       |\n" +
				"2|       ###     |\n" +
				"1|   #######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "L";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|       N       |\n" +
				"2|     OA###     |\n" +
				"1|   #######     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_56() {
		// Check can move girder to left
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|     NN        |\n" +
				"2|     N OA       |\n" +
				"1|  ########     |\n" +
				"0|  #            |\n" +
				"  012345678901234";

		String sequence = "LLL";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|   NN          |\n" +
				"2|   NOA         |\n" +
				"1|  ########     |\n" +
				"0|  #            |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_57() {
		// Check can move girder up
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|     NN        |\n" +
				"2|     N OA       |\n" +
				"1|  ########     |\n" +
				"0|  #            |\n" +
				"  012345678901234";

		String sequence = "LLU";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|    NN         |\n" +
				"3|    NO         |\n" +
				"2|     A         |\n" +
				"1|  ########     |\n" +
				"0|  #            |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_58() {
		// Check can move girder right
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|    ONNN       |\n" +
				"2|    AN N       |\n" +
				"1|  ########     |\n" +
				"0|  #            |\n" +
				"  012345678901234";

		String sequence = "RR";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|       NNN     |\n" +
				"2|     AON N     |\n" +
				"1|  ########     |\n" +
				"0|  #            |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_59() {
		// Check can girder and obstructions
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|    ONNN       |\n" +
				"2|    AN N##     |\n" +
				"1|  ########     |\n" +
				"0|  #            |\n" +
				"  012345678901234";

		String sequence = "RR";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|    ONNN       |\n" +
				"2|    AN N##     |\n" +
				"1|  ########     |\n" +
				"0|  #            |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}


	@Test
	public void test_60() {
		// Check can girder and obstructions
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|    ##         |\n" +
				"4|   NNN         |\n" +
				"3|    ON         |\n" +
				"2|    A          |\n" +
				"1|  ########     |\n" +
				"0|  #            |\n" +
				"  012345678901234";

		String sequence = "UU";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|    ##         |\n" +
				"4|   NNN         |\n" +
				"3|    ON         |\n" +
				"2|    A          |\n" +
				"1|  ########     |\n" +
				"0|  #            |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_61() {
		// Check girder and gravity
		String startingBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|        NN     |\n" +
				"2|    CBAO N     |\n" +
				"1|  ########     |\n" +
				"0|  #            |\n" +
				"  012345678901234";

		String sequence = "UR";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|       AO      |\n" +
				"2|      CB NN    |\n" +
				"1|  ########N    |\n" +
				"0|  #            |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_62() {
		// Check girder and gravity
		String startingBoard =
				"7|               |\n" +
				"6| @   NN        |\n" +
				"5|     NN OABC   |\n" +
				"4|      ####     |\n" +
				"3|               |\n" +
				"2|               |\n" +
				"1|  ########     |\n" +
				"0|  #            |\n" +
				"  012345678901234";

		String sequence = "LL";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|      OABC     |\n" +
				"4|      ####     |\n" +
				"3|    NN         |\n" +
				"2|    NN         |\n" +
				"1|  ########     |\n" +
				"0|  #            |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_63() {
		// Check girder and gravity
		String startingBoard =
				"7|               |\n" +
				"6| @      NN     |\n" +
				"5|    BAO NN     |\n" +
				"4|   #######     |\n" +
				"3|               |\n" +
				"2|               |\n" +
				"1|  ########     |\n" +
				"0|  #            |\n" +
				"  012345678901234";

		String sequence = "RR";

		String finalBoard =
				"7|               |\n" +
				"6| @       NN    |\n" +
				"5|      BAONN    |\n" +
				"4|   #######     |\n" +
				"3|               |\n" +
				"2|               |\n" +
				"1|  ########     |\n" +
				"0|  #            |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_64() {
		// Check girder and gravity
		String startingBoard =
				"7|               |\n" +
				"6| @      NN     |\n" +
				"5|    BAO NN     |\n" +
				"4|   #######     |\n" +
				"3|               |\n" +
				"2|               |\n" +
				"1|  ########     |\n" +
				"0|  #            |\n" +
				"  012345678901234";

		String sequence = "RRR";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|       BAO     |\n" +
				"4|   #######     |\n" +
				"3|               |\n" +
				"2|               |\n" +
				"1|  ########     |\n" +
				"0|  #            |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_65() {
		// Check girder and gravity
		String startingBoard =
				"7|               |\n" +
				"6| @    NN       |\n" +
				"5|     AON       |\n" +
				"4|   ####        |\n" +
				"3|         #     |\n" +
				"2|               |\n" +
				"1|  ########     |\n" +
				"0|  #            |\n" +
				"  012345678901234";

		String sequence = "RR";

		String finalBoard =
				"7|               |\n" +
				"6| @             |\n" +
				"5|        NN     |\n" +
				"4|   ####  N     |\n" +
				"3|         #     |\n" +
				"2|       AO      |\n" +
				"1|  ########     |\n" +
				"0|  #            |\n" +
				"  012345678901234";
		checkValid(sequence,startingBoard,finalBoard);
	}

	@Test
	public void test_66() {
		// Check girder and support
		String startingBoard =
				"7|       @       |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|   O  N        |\n" +
				"3|   A NNN       |\n" +
				"2|   B#####      |\n" +
				"1|   #######     |\n" +
				"0|  #########    |\n" +
				"  012345678901234";

		String sequence = "RRURURUU!";

		String finalBoard =
				"7|       O       |\n" +
			    "6|       A       |\n" +
				"5|       B       |\n" +
				"4|       N       |\n" +
				"3|      NNN      |\n" +
				"2|    #####      |\n" +
				"1|   #######     |\n" +
				"0|  #########    |\n" +
				"  012345678901234";

		checkValid(sequence,startingBoard,finalBoard);
	}

	/**
	 * ============================================================
	 * Helper Functions
	 * ============================================================
	 */

	/**
	 * This method checks whether or not the given input string is valid.
	 *
	 * ** DO NOT MODIFY THIS FUNCTION **
	 *
	 * @param sequence
	 */
	public void checkValid(String sequence, String startingBoard, String expectedFinalBoard) {
		Game game;
		System.out
		.println("===================================================");
		System.out.println("TEST " + determineTestNumber());
		System.out
		.println("===================================================");
		// Boards set to 15x8 dimension
		game = new Parser(sequence).parse(15, 8);
		game.initialiseBoard(startingBoard);
		game.run();
		// Second, create the board and apply each move to the board.
		String finalBoard = game.toString();
		if (!finalBoard.equals(expectedFinalBoard)) {
			System.out.println("EXPECTED:");
			System.out.println(expectedFinalBoard);
			System.out.println("ACTUAL:");
			System.out.println(finalBoard);
			// Using assertEquals enables result comparator in Eclipse
			assertEquals(expectedFinalBoard, finalBoard, "Invalid final board --- see the console for details");
		}
	}

	/**
	 * This method checks whether or not the given input string is invalid.
	 *
	 * ** DO NOT MODIFY THIS FUNCTION **
	 *
	 * @param sequence
	 */
	public void checkInvalid(String sequence, String startingBoard) {
		Game game;

		System.out
		.println("===================================================");
		System.out.println("TEST " + determineTestNumber());
		System.out
		.println("===================================================");

		// First, parse the list of moves
		try {
			// Boards set to 15x8 dimension
			game = new Parser(sequence).parse(15, 8);
			game.initialiseBoard(startingBoard);
			game.run();
			System.out.println("Test should have generated a GameError, but didn't");
			System.out.println("\nBOARD:");
			System.out.println(game.toString());
			fail("Test failed to throw a GameError (as expected)");
		} catch (GameError e) {
			// This is what we want to happen, since the input game is invalid.
			// Therefore, we simply exit the test correctly.
			return;
		}
	}

	/**
	 * Determine the number of the test being executed based on its method name.
	 *
	 * ** DO NOT MODIFY THIS FUNCTION **
	 *
	 * @return
	 */
	private int determineTestNumber() {
		StackTraceElement[] e = Thread.currentThread().getStackTrace();
		String line = e[3].toString();
		int numStart = line.indexOf('_')+1;
		return Integer.valueOf(line.substring(numStart, numStart+2));
	}
}
