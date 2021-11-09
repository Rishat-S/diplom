package ru.netology.netologydiplom.repository;

import org.springframework.data.repository.CrudRepository;
import ru.netology.netologydiplom.entity.TokenBlacklist;

public interface TokenBlacklistRepository extends CrudRepository<TokenBlacklist, String> {
}
