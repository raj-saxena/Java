import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.xyz.Minesweeper;

/**
 * Created by raj on 21/4/16.
 */
public class MinesweeperTest {

	@Test
	public void createMineField1x1Test() {
		Minesweeper minesweeper = new Minesweeper();
		String inputLayout = "x";
		String expectedMinefield = "x";
		minesweeper.createMinefield(inputLayout);
		String output = minesweeper.show();
		assertEquals(expectedMinefield, output);
	}

	@Test
	public void createMineField2x2Test() {
		Minesweeper minesweeper = new Minesweeper();
		String inputLayout = "xm,xx";
		String expectedMinefield = "xx\nxx";
		minesweeper.createMinefield(inputLayout);
		String output = minesweeper.show();
		assertEquals(expectedMinefield, output);
	}

	@Test
	public void createMinefieldTest() {
		Minesweeper minesweeper = new Minesweeper();
		String inputLayout = "xxm,xmx,xxx";
		String expectedMinefield = "xxx\nxxx\nxxx";
		minesweeper.createMinefield(inputLayout);
		String output = minesweeper.show();
		assertEquals(expectedMinefield, output);

	}

	@Test
	public void openMineFieldTestOne() {
		Minesweeper minesweeper = new Minesweeper();
		String inputLayout = "xxm,xmx,xxx";
		minesweeper.createMinefield(inputLayout);
		minesweeper.process("o(0,0)");
		String output = minesweeper.show();
		String expectedMinefield = "0xx\nxxx\nxxx";
		assertEquals(expectedMinefield, output);
	}

	@Test
	public void openMineFieldTestTwo() {
		Minesweeper minesweeper = new Minesweeper();
		String inputLayout = "xxm,xmx,xxx";
		minesweeper.createMinefield(inputLayout);
		minesweeper.process("o(0,0)");
		minesweeper.process("o(0,1)");
		String output = minesweeper.show();
		String expectedMinefield = "00x\nxxx\nxxx";
		assertEquals(expectedMinefield, output);
	}

	@Test
	public void openAndFlagMineFieldTest() {
		Minesweeper minesweeper = new Minesweeper();
		String inputLayout = "xxm,xmx,xxx";
		minesweeper.createMinefield(inputLayout);
		minesweeper.process("o(0,0)");
		minesweeper.process("o(0,1)");
		minesweeper.process("f(0,2)");
		String output = minesweeper.show();
		String expectedMinefield = "00f\nxxx\nxxx";
		assertEquals(expectedMinefield, output);
	}

	@Test
	public void openMine() {
//		Minesweeper minesweeper = new Minesweeper();
//		String inputLayout = "xxm,xmx,xxx";
//		minesweeper.createMinefield(inputLayout);
//		minesweeper.process("o(1,1)");
//		String output = minesweeper.show();
//		String expectedMinefield = "00f\nxxx\nxxx";
//		assertEquals(expectedMinefield, output);
	}
}
