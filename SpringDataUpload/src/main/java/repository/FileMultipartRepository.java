package repository;

import model.request.FileMultipart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileMultipartRepository extends JpaRepository<FileMultipart, String> {

}
