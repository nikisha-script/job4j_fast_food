import React from "react"
import ContentLoader from "react-content-loader"

const Sceleton = () => (
  <ContentLoader 
    speed={2}
    width={400}
    height={150}
    viewBox="0 0 400 150"
    backgroundColor="#f3f3f3"
    foregroundColor="#ecebeb"
  >
    <circle cx="10" cy="80" r="8" /> 
    <rect x="25" y="75" rx="5" ry="5" width="220" height="10" /> 
    <circle cx="10" cy="110" r="8" /> 
    <rect x="25" y="105" rx="5" ry="5" width="220" height="10" /> 
    <rect x="123" y="27" rx="0" ry="0" width="1" height="37" /> 
    <rect x="59" y="19" rx="0" ry="0" width="152" height="47" />
  </ContentLoader>
)

export default Sceleton

