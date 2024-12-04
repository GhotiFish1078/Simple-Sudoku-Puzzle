package sudoku_game;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * This class is used to actually fetch files using HTTPClient
 */
public class SudokuAPI {
    private static final String link = "https://sudoku-api.vercel.app/api/dosuku";

    public static int[][][] getPuzzleFromAPI() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(link))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject jsonResponse = new JSONObject(response.body());
        JSONObject newBoard = jsonResponse.getJSONObject("newboard");
        JSONArray grids = newBoard.getJSONArray("grids");
        JSONObject firstGrid = grids.getJSONObject(0);

        JSONArray puzzleArray = firstGrid.getJSONArray("value");
        JSONArray solutionArray = firstGrid.getJSONArray("solution");

        int[][] puzzle = parseBoard(puzzleArray);
        int[][] solution = parseBoard(solutionArray);

        return new int[][][] { puzzle, solution };
    }

    private static int[][] parseBoard(JSONArray boardArray) {
        int[][] board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            JSONArray row = boardArray.getJSONArray(i);
            for (int j = 0; j < 9; j++) {
                board[i][j] = row.getInt(j);
            }
        }
        return board;
    }
}
