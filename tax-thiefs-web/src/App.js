import React, { useEffect, useState } from "react";
import { RenderAfterNavermapsLoaded, NaverMap, Marker } from "react-naver-maps";

import "./App.css";
import { getCurrentLocation, DEFAULT_LOCATION }
  from './services/location.service'

function App() {
  const coordinates = DEFAULT_LOCATION;
  const [ref, setRef] = useState();

  useEffect(() => {
    if (!ref) {
      return;
    }

    (async () => {
      try {
        const { lat, lng } = await getCurrentLocation();
        ref.panTo(new ref.props.navermaps.LatLng(lat, lng));
      } catch (err) {
        alert("에러가 발상했습니다. ", err);
      }
    })();
  }, [ref]);

  const markers = [
    [37.360747, 127.105193], // 더 샵 스타파크
    [37.3595704, 127.105399], // 그린팩토리
    [37.372616, 127.107392] // 정자동 파크뷰
  ];

  return (
    <div className="App">
      <RenderAfterNavermapsLoaded
        ncpClientId={"qiq4esm1zw"}
        error={<p>Maps Load Error</p>}
        loading={<p>Maps Loading...</p>}
      >
        <NaverMap
          mapDivId={"map"}
          style={{
            width: "100%",
            height: "100%"
          }}
          naverRef={ref => setRef(ref)}
          defaultCenter={{ lat: coordinates.lat, lng: coordinates.lng }}
          defaultZoom={10}
        >
          {ref && markers.map((coordinates, index) => (
            <Marker
              position={new ref.props.navermaps.LatLng(coordinates[0], coordinates[1])}
              key={index}
              onClick={() => {
                alert("여기는 네이버 입니다.");
              }}
            />
          ))}
        </NaverMap>
      </RenderAfterNavermapsLoaded>
    </div>
  );
}

export default App;
