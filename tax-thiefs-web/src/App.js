import React from 'react';
import { RenderAfterNavermapsLoaded, NaverMap, Marker } from 'react-naver-maps';

import './App.css';

function App(props) {
  const navermaps = window.naver.maps;

  const markers = [
    [37.360747, 127.105193], // 더 샵 스타파크
    [37.3595704, 127.105399], // 그린팩토리
    [37.372616, 127.107392], // 정자동 파크뷰
  ]
  return (
    <div className="App">
      <RenderAfterNavermapsLoaded
        ncpClientId={'qiq4esm1zw'}
        error={<p>Maps Load Error</p>}
        loading={<p>Maps Loading...</p>}
      >
        <NaverMap
          mapDivId={'map'}
          style={{
            width: '100%',
            height: '100%',
          }}
          defaultCenter={{ lat: 37.3595704, lng: 127.105399 }}
          defaultZoom={10}
        >
          {
            markers.map(coordinates => (
              <Marker
                position={new navermaps.LatLng(coordinates[0], coordinates[1])}
                onClick={() => {
                  alert('여기는 네이버 입니다.')
                }}
              />
            ))
          }
        </NaverMap>
      </RenderAfterNavermapsLoaded>
    </div>
  );
}

export default App;
