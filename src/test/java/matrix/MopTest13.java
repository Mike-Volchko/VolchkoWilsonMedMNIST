/*
 * Copyright (c) Ron Coleman
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package matrix;

import neural.labs.lab03_06.Mop;
import neural.matrix.IMop;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.stream.IntStream;

/**
 * Tests dice with start > end 6x6 matrix.
 * @author Mike Volchko & Oliver Wilson
 * @date 17 Sep 2022
 */
//@FixMethodOrder(MethodSorters.DEFAULT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MopTest13 {
    // TODO: instantiate a concrete IMop here
    IMop mop = new Mop();

    // Matrix is this size to anticipate start, mid, end testing.
    final double[][] TEST_MATRIX = {
            { 1,  2,  3, 19, 20, 21},
            { 4,  5,  6, 22, 23, 24},
            { 7,  8,  9, 25, 26, 27},
            {10, 11, 12, 28, 29, 30},
            {13, 14, 15, 31, 32, 33},
            {16, 17, 18, 34, 35, 36}
    };

    final double[][] EXPECTED_MATRIX = {
            {0}
    };

    /**
     * Tests that dice matches expectations.
     */
    @Test
    public void test() {
        final double[][] dice = mop.dice(TEST_MATRIX,3,2);

        int numRows = dice.length;
        assert(numRows == EXPECTED_MATRIX.length);

        int numCols = dice[0].length;
        assert(numCols == EXPECTED_MATRIX[0].length);

        IntStream.range(0,numRows).forEach( rowno -> {
            IntStream.range(0,numCols).forEach(colno -> {
                assert(dice[rowno][colno] == EXPECTED_MATRIX[rowno][colno]);
            });
        });

        mop.print(this.getClass().getName()+" dice",dice);
    }
}
