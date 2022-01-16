package com.github.wezzen.logicgamez.auth;

import com.github.wezzen.logicgamez.database.RoleDto;
import com.github.wezzen.logicgamez.database.RoleRepository;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

  private final LoadingCache<String, RoleDto> roleCache;

  public RoleServiceImpl(final RoleRepository roleRepository) {
    this.roleCache =
        CacheBuilder.newBuilder()
            .build(
                new CacheLoader<>() {
                  @Override
                  public @NonNull RoleDto load(@NonNull String key) {
                    return roleRepository
                        .findById(key)
                        .orElse(roleRepository.save(new RoleDto(key)));
                  }
                });
  }

  @Override
  public RoleDto getOrCreateRole(final String roleName) {
    return roleCache.getUnchecked(roleName);
  }
}
