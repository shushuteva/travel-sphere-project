package com.travelsphere.travelsphere.dto;

public class HotelDto {

    private Integer hotelId;
    private Integer avilableRooms;
    private String hotelAddress;
    private String hotelDescription;
    private String hotelName;
    private String hotelType;

    public HotelDto() {
    }

    public HotelDto(Integer hotelId, Integer avilableRooms, String hotelAddress,
                    String hotelDescription, String hotelName, String hotelType) {
        this.hotelId = hotelId;
        this.avilableRooms = avilableRooms;
        this.hotelAddress = hotelAddress;
        this.hotelDescription = hotelDescription;
        this.hotelName = hotelName;
        this.hotelType = hotelType;
    }

    public Integer getHotelId() { return hotelId; }
    public void setHotelId(Integer hotelId) { this.hotelId = hotelId; }

    public Integer getAvilableRooms() { return avilableRooms; }
    public void setAvilableRooms(Integer avilableRooms) { this.avilableRooms = avilableRooms; }

    public String getHotelAddress() { return hotelAddress; }
    public void setHotelAddress(String hotelAddress) { this.hotelAddress = hotelAddress; }

    public String getHotelDescription() { return hotelDescription; }
    public void setHotelDescription(String hotelDescription) { this.hotelDescription = hotelDescription; }

    public String getHotelName() { return hotelName; }
    public void setHotelName(String hotelName) { this.hotelName = hotelName; }

    public String getHotelType() { return hotelType; }
    public void setHotelType(String hotelType) { this.hotelType = hotelType; }
}
