package id.co.mii.serverapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import id.co.mii.serverapp.Model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
