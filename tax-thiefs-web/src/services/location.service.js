export const DEFAULT_LOCATION = { lat: 37.5388448, lng: 126.9834483 }

const getCurrentPosition = () => new Promise((resolve, reject) => {
  navigator.geolocation.getCurrentPosition(resolve, reject);
});

export const getCurrentLocation = async () => {
  if (!navigator.geolocation) {
    return DEFAULT_LOCATION;
  }

  const { coords } = await getCurrentPosition();
  return {
    lat: coords.latitude,
    lng: coords.longitude,
  };
}
