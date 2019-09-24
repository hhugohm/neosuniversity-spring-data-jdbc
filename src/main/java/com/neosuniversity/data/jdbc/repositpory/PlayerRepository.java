package com.neosuniversity.data.jdbc.repositpory;

import com.neosuniversity.data.jdbc.domain.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository  extends CrudRepository<Player,Integer> {
}
