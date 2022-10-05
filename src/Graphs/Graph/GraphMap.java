package Graphs.Graph;

import java.util.List;

public interface GraphMap<T> {

    public List<T> dfs(T start);
    public List<T> bfs(T start);

}
