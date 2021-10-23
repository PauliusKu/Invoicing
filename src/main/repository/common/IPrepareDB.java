package main.repository.common;

import java.util.List;

public interface IPrepareDB {
    void clear();
    void prepare(List<String> dataList);
}
