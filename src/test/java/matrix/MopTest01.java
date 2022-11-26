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
 * Tests slice from the middle of the matrix.
 * @author Mike Volchko & Oliver Wilson
 * @date 17 Sep 2022
 */
//@FixMethodOrder(MethodSorters.DEFAULT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MopTest01 {
    // TODO: instantiate a concrete IMop here
    IMop mop = new Mop();

    // Matrix is this size to anticipate start, mid, end testing.
    final double[][] TEST_MATRIX = {
            { 1,  2,  3},
            { 4,  5,  6},
            { 7,  8,  9},
            {10, 11, 12},
            {13, 14, 15}
    };

    final double[][] EXPECTED_MATRIX = {
            { 4,  5, 6},
            { 7,  8, 9}
    };

    /**
     * Tests that slice matches expectations.
     */
    @Test
    public void test() {
        final double[][] slice = mop.slice(TEST_MATRIX,1,3);

        int numRows = slice.length;
        assert(numRows == EXPECTED_MATRIX.length);

        int numCols = slice[0].length;
        assert(numCols == EXPECTED_MATRIX[0].length);

        IntStream.range(0,numRows).forEach( rowno -> {
            IntStream.range(0,numCols).forEach(colno -> {
                assert(slice[rowno][colno] == EXPECTED_MATRIX[rowno][colno]);
            });
        });

        mop.print(this.getClass().getName()+" slice",slice);
    }
}
