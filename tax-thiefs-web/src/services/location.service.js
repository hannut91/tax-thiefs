export const getCurrentLocation = () =>
  new Promise((resolve, reject) => {
    if (!"geolocation" in navigator) {
      return resolve({ lat: 37.5388448, lng: 126.9834483 });
    }
    navigator.geolocation.getCurrentPosition(position => {
      resolve({
        lat: position.coords.latitude,
        lng: position.coords.longitude
      });
    }, reject);
  });
