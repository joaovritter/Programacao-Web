package com.joaozao.phonedto.mapper;

import com.joaozao.phonedto.dto.PhoneRequestDTO;
import com.joaozao.phonedto.dto.PhoneResponseDTO;
import com.joaozao.phonedto.model.Phone;

public class PhoneMapper {
    public PhoneMapper() {
    }


    public PhoneResponseDTO convertToResponseDTO (Phone phone) {
      PhoneResponseDTO responseDTO = new PhoneResponseDTO();
        responseDTO.setId(phone.getId());
        responseDTO.setNumero(phone.getNumero());

        return responseDTO;
    }

    public Phone convertToEntity (PhoneResponseDTO responseDTO) {
        Phone phone = new Phone();
        phone.setId(responseDTO.getId());
        phone.setNumero(responseDTO.getNumero());

        return phone;
    }
}
